#Require the package so you can use it
require("jsonlite")
require("httr")
require("readr")

#TODO: Add your token here
token <- "<Enter your authentication token here>" 
base <- "https://api-sandbox.ess-dive.lbl.gov/"
header_authorization <- paste("bearer",token, sep=" ")
endpoint <- "packages"

#TODO: Add your file directory here
# jsonld_path <- "~/directory/to/your/jsonld/file"
jsonld_path <- "../../data/JSON-LD/example-2.jsonld"
json_file <- read_file(jsonld_path)