# Submit a Data Package
# The following lines of code validate JSON-LD metadata for a single data package. 
 # The example provided is from the ESS-DIVE sandbox site.  
 # (See https://data-sandbox.ess-dive.lbl.gov/#view/doi:10.3334/CDIAC/spruce.001).  
# 
# Due to R complex JSON-LD support  limitations, you need to create a text file of your
# JSON-LD and add it’s directory in the following read_file function. 


source("setup.r")
source("config.r")

# Prepare and submit the metadata for validation 

call_post_package <- paste(base,endpoint, sep="/")
post_package = POST(call_post_package,
                    body = json_file,
                       add_headers(Authorization=header_authorization,
                       "Content-Type"="application/json"))


# Transform the result into a data frame. (Ignore warning)
post_package_text <- content(post_package, "text")
post_package_json <- fromJSON(post_package_text)

# Check the status and review the results
if(!http_error(post_package) ){
  attributes(post_package_json)
  cat("View URL: ")
  cat(post_package_json$viewUrl)
  cat("\n")
  cat("Name: ")
  cat(post_package_json$dataset$name)
}else {
  http_status(post_package)
  message(post_package_text)
}
