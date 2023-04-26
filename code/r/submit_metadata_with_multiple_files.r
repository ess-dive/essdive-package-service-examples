# Load required libraries
source("setup.r")
source("config.r")

### Set up the required variables ###
files_upload_directory <- "/PATH/TO/UPLOAD/DIRECTORY" # TODO: Add your file directory here

# List the files in the directory
files <- list.files(files_upload_directory)
files <- files[files != basename(jsonld_path)]


# Function to check the package availability
check_package_availability <- function(package_id, base, endpoint, header_authorization, max_retries = 5) {
   Sys.sleep(5) # Wait for 5 seconds before trying again
   for (i in 1:max_retries) {
    get_package_url <- paste0(base, endpoint, "/", package_id)
    get_package_response <- httr::GET(get_package_url, add_headers("Authorization" = header_authorization))
  
      if (httr::status_code(get_package_response) == 200) {
        return(TRUE)
      } else {
              Sys.sleep(5) # Wait for 5 seconds before trying again
      }
  }
  return(FALSE)
}

# POST the first file and JSON-LD
first_file <- file.path(files_upload_directory, files[1])
post_packages_url <- paste0(base, endpoint)
post_package_response <- httr::POST(post_packages_url,
                                  body = list("json-ld" = upload_file(jsonld_path, "application/json"),
                                              "data" = upload_file(first_file)),
                                  add_headers("Authorization" = header_authorization),
                                  encode = "multipart")

# Check the POST response for errors
if (post_package_response$status_code != 201) {
  cat("Error in POST request:", httr::content(post_package_response, "text", encoding = "UTF-8"), "\n")
} else {
  post_response_content <- httr::content(post_package_response, "parsed", encoding = "UTF-8")
  view_url <- post_response_content$viewUrl
  package_id <- gsub(".*/view/([^/]+)$", "\\1", view_url)
  
  if (!check_package_availability(package_id, base, endpoint, header_authorization)) {
    cat("Error: Package with ID", package_id, "not found after multiple retries. Skipping file", files[1], "\n")
  }

  # Loop through the remaining files and update them using PUT requests
  for (i in 2:length(files)) {
    file_to_upload <- file.path(files_upload_directory, files[i])
  
    if (!check_package_availability(package_id, base, endpoint, header_authorization)) {
      cat("Error: Package with ID", package_id, "not found after multiple retries. Skipping file", files[i], "\n")
      next
    }

    put_package_url <- paste0(base, endpoint, "/", package_id)
    put_package_response <- httr::PUT(put_package_url,
                                   body = list("data" = upload_file(file_to_upload)),
                                   add_headers("Authorization" = header_authorization),
                                   encode = "multipart")
  
    if (httr::status_code(put_package_response) == 200) {
      put_response_content <- httr::content(put_package_response, "parsed", encoding = "UTF-8")
      view_url <- put_response_content$viewUrl
      # Extract package ID from the view URL for the next PUT request
      package_id <- gsub(".*/view/([^/]+)$", "\\1", view_url)
    } else {
      cat("Error in PUT request for file", files[i], ":", httr::content(put_package_response, "text", encoding = "UTF-8"), "\n")
    }
  }
  
  # Print the view URL
  cat("View URL:", view_url, "\n")
}
