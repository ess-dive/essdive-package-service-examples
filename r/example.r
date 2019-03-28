install.packages("httr")
install.packages("jsonlite")
install.packages("readr")

#Require the package so you can use it
require("jsonlite")
require("httr")
library(readr)

# Setup the package service information

#TODO: Add your token here
token <- "<Enter your authentication token here>" 
base <- "https://api-sandbox.ess-dive.lbl.gov/"
header_authorization <- paste("bearer",token, sep=" ")
endpoint <- "packages"

# Submit a Data Package
# The following lines of code validate JSON-LD metadata for a single data package. 
 # The example provided is from the ESS-DIVE sandbox site.  
 # (See https://data-sandbox.ess-dive.lbl.gov/#view/doi:10.3334/CDIAC/spruce.001).  
# 
# Due to R complex JSON-LD support  limitations, you need to create a text file of your
# JSON-LD and add it’s directory in the following read_file function. 


#TODO: Add your file directory here
json_file <- read_file("~/directory/to/your/jsonld/file")

# Prepare and submit the metadata for validation 

call_post_package <- paste(base,endpoint, sep="")
post_package = POST(call_post_package,
                    body = json_file,
                       add_headers(Authorization=header_authorization,
                       "Content-Type"="application/json"))


# Review the results
content(post_package)

# To submit the metadata and data files, create a folder and
# add your data files to it then execute the following code:

call_post_package <- paste(base,endpoint, sep="")

post_package = POST(call_post_package, body=list("json-ld"=json_file, data=upload_file("your-directory/your-file", "text/csv")),add_headers(Authorization=header_authorization, "Content-Type"="multipart/form-data"))

# Review the results

content(post_package)


# Get a list of data packages
# The following lines of code will get the list of data package metadata 
# that you have permissions to edit.  This will return the most recent 25 records. 
# If you have access to more than 25 packages, use the row_start and page_size query 
# parameters to page through the results. 

# Call GET /packages
call_get_packages <- paste(base,endpoint, sep="")
get_packages = GET(call_get_packages,
       add_headers(Authorization=header_authorization))
       
# Transform the result into a data frame. (Ignore the warning)

get_packages_text <- content(get_packages, "text")
get_packages_json <- fromJSON(get_packages_text)
get_packages_df <- as.data.frame(get_packages_json)


# Check for errors
if(!http_error(post_package) ){
  # Print the returned columns
  print(colnames(get_packages_df))

  # print the ESS-DIVE Ids
  print(get_packages_df['result.id'])

  # Iterator over the dataset column and print the data package name
  for ( d in get_packages_df['result.dataset']) { print(d['name']) }
}else {
  http_status(post_package)
}


# Get a single data package
# The following lines of code will get the metadata for a single data
# package that you have permissions to edit.  
 
id <- "<Place an ESS-DIVE identifier here>"
call_get_package <- paste(base,endpoint,id, sep="")
get_package = GET(call_get_package,
    add_headers(Authorization=header_authorization))

# Transform the result into a data frame. (Ignore the warning message)
get_package_text <- content(get_package, "text")
get_package_json <- fromJSON(get_package_text)

# Check for errors
if(!http_error(post_package) ){
  print(get_package_json)
}else {
  http_status(post_package)
}