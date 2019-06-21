#Require the package so you can use it
require("jsonlite")
require("httr")
require("readr")

#TODO: Add your token here
token <- "<Enter your authentication token here>" 
base <- "https://api-sandbox.ess-dive.lbl.gov/"
header_authorization <- paste("bearer",token, sep=" ")
endpoint <- "packages"

# Due to R complex JSON-LD support  limitations, you need to create a text file of your
# and JSON-LD and add it’s directory in the following read_file function. 

#TODO: Add your file directory here
# jsonld_path <- "~/directory/to/your/jsonld/file"
jsonld_path <- "../../data/JSON-LD/example-2.jsonld"
json_file <- read_file(jsonld_path)