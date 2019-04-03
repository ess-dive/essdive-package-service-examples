source("setup.r")
source("config.r")


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
if(!http_error(get_packages) ){
  # Print the returned columns
  print(colnames(get_packages_df))

  # print the ESS-DIVE Ids
  print(get_packages_df['result.id'])

  # Iterator over the dataset column and print the data package name
  for ( d in get_packages_df['result.dataset']) { print(d['name']) }
}else {
  http_status(get_packages)
}
