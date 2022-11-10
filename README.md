# ESS-DIVE Package Service Examples
[![Binder](https://mybinder.org/badge_logo.svg)](https://mybinder.org/v2/gh/ess-dive/essdive-package-service-examples/main)

## Getting started with ESS-DIVE Package Service 1.2.0
The ESS-DIVE Package Service is a service that enables projects to programmatically store data packages with ESS-DIVE. This is an alternative to using the ESS-DIVE web portal form for data uploads. This service encodes metadata using the JSON-LD specification. JSON-LD is a schema to encode linked Data using JSON, and in the future will be used by Google to index metadata for searches. The use of the standardized JSON-LD schema will dramatically increase the visibility of data packages, and also enable projects to create one-time code that can be reused for periodic uploads of data packages to ESS-DIVE.

The ESS-DIVE Package service allows you to submit JSON-LD data package metadata to ESS-DIVE’s sandbox instance, to test whether metadata curated by projects are mapped correctly onto ESS-DIVE’s data package metadata schema.  Data package metadata refers to the top level metadata that enables a data package to be “discoverable” in search results.  Examples of top-level metadata include the title, abstract, authors, variables and keywords. Other file-level metadata, such as those that describe the the data file structure or variables  are not included in this service.  The beta version also does not include submission of data files to ESS-DIVE.

Provide feedback on the package service to ess-dive-support@lbl.gov. 

### Repository folder hierarchy: 

- code                ( Coding examples in three programming languages - includes all basic API functionalities. )

    - [java](https://github.com/ess-dive/essdive-package-service-examples/tree/master/code/java)         ( Java coding example. )

    - [python](https://github.com/ess-dive/essdive-package-service-examples/tree/master/code/python)               ( Python coding example. )

    - [r](https://github.com/ess-dive/essdive-package-service-examples/tree/master/code/r)                     ( R coding example. )

- data               ( Data files that are used in the examples. )

    - [files](https://github.com/ess-dive/essdive-package-service-examples/tree/master/data/files)                     ( File examples to be uploaded using the package service. )

    - [JSON-LD](https://github.com/ess-dive/essdive-package-service-examples/tree/master/data/JSON-LD)             ( JSON-LDs example files that demonstrate required fields usage. )

- [demo-notebooks](https://github.com/ess-dive/essdive-package-service-examples/tree/master/demo-notebooks) (stand alone Jupyter Notebooks that demonstrate how to use specific API operations)

 **For all examples, you need to add your token into the token variable as well as adding any customizations to run certain functions.  For example, an identifier to run the get package function. You will find all the needed field with a *TODO* comment next to it.**

#### To use the Java example you need to install `java 11.0.1 2018-10-16 LTS`:
  
 ###### First run the setup bash script to install all libraries dependancies.
  
  ```bash
  ./setup.sh
  ```
  
  ###### Then to compile the Java code:
  
  ```bash
  ./run.sh
  ```
  
#### To use the Python example you need to install request using (we recommend using a virtual environment): 

  ```
  pip install requests
  ```
  
 ###### To setup your script: 
  
  Enter your ESS-DIVE authentication token inside `.config` and then run the following:
    
  ```
  source .config
  ```
 ###### To run your script: 

  ```bash
  python <function_file_name>.py
  ```
  
#### To use the R example you need to install `R scripting front-end` version 3.5.2 (2018-12-20):
###### To setup your script: 
  Enter your ESS-DIVE authentication token in `config.r` file.
  
###### To run your script: 

  ```bash
  Rscript <function_file_name>.r
  ```
  
### Troubleshooting http errors: 
If during your code development you encounter http errors, here are few common error codes and their suggested areas to look into based on your http codes. This doesn't replace checking the error messages but it could add an extra debugging help.
- 400: Are you submitting your metadata abiding to the correct <a href="https://api-sandbox.ess-dive.lbl.gov/" target="_blank">schema</a> ?
- 401: Did you check the validity of your access token used? is it expired? 
- 404: Are you sure the set URL is correct? Did you check if you had any extra slashes in your base URL? 


