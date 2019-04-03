# Setup the package service information

installPackage <- function(packageName)
  {
    if (!require(packageName,character.only = TRUE))
    {
      install.packages(packageName,dep=TRUE, repos="http://cran.rstudio.com/")
        if(!require(packageName,character.only = TRUE)) stop("Package not found")
    }
  }

installPackage("httr")
installPackage("jsonlite")
installPackage("readr")
