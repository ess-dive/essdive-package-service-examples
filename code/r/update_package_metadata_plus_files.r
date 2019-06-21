# Update Data Package Metadata ONLY
# The following lines of code update JSON-LD metadata for a single data package. 
# The example provided is from the ESS-DIVE sandbox site.  
# (See https://data-sandbox.ess-dive.lbl.gov/#view/doi:10.3334/CDIAC/spruce.001).  
# 


source("setup.r")
source("config.r")

#TODO Add your package ID here
id <- "<Place an ESS-DIVE identifier here>"
file_path <- "../../data/files/text_file.txt"

# Prepare and update the metadata for a data package 
# Notice: The JSON-LD is submitted as a string
call_put_package <- paste(base,endpoint,id,sep="/")
put_package = PUT(call_put_package,
                   body=list("json-ld"="{ \"datePublished\": \"2019\" }",
                            data=upload_file(file_path,"text/plain")),
                    add_headers(Authorization=header_authorization,
                                "Content-Type"="multipart/form-data"))


# Transform the result into a data frame. (Ignore warning)
put_package_text <- content(put_package, "text")
put_package_json <- fromJSON(put_package_text)

# Check the status and review the results
if(!http_error(put_package) ){
  attributes(put_package_json)
  cat("View URL: ")
  cat(put_package_json$viewUrl)
  cat("\n")
  cat("Date Published: ")
  cat(put_package_json$dataset$datePublished)
}else {
  http_status(put_package)
  message(put_package_text)
}
