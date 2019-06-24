source("setup.r")
source("config.r")


# Get a single data package
# The following lines of code will get the metadata for a single data
# package that you have permissions to edit.  
 
 #TODO Add your package ID here
id <- "<Place an ESS-DIVE identifier here>"
call_get_package <- paste(base,endpoint,id, sep="/")
get_package = GET(call_get_package,
    add_headers(Authorization=header_authorization))

# Transform the result into a data frame. (Ignore the warning message)
get_package_text <- content(get_package, "text")
get_package_json <- fromJSON(get_package_text)

# Check for errors
if(!http_error(get_package) ){
  print(get_package_json)
}else {
  http_status(get_package)
}
