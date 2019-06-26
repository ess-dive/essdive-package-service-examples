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

call_put_package <- paste(base,endpoint,get_package_json$id, sep="/")

put_package = PUT(call_put_package,
                  body = "{ \"name\": \"My Tutorial Title\" }",
                  add_headers(Authorization=header_authorization,
                      "Content-Type"="application/json"))


put_package_text <- content(put_package, "text")
put_package_json <- fromJSON(put_package_text)

# Review the results
if(!http_error(put_package) ){
  attributes(put_package_json)
  put_package_json$viewUrl
  put_package_json$dataset$name
} else {
  http_status(put_package)
  print(put_package_text)
}
