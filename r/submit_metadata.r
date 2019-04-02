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

call_post_package <- paste(base,endpoint, sep="")
post_package = POST(call_post_package,
                    body = json_file,
                       add_headers(Authorization=header_authorization,
                       "Content-Type"="application/json"))


# Review the results
content(post_package)