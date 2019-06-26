from setup import *

# The following lines of code validate JSON-LD metadata for a single data package.
# The example provided is from the ESS-DIVE sandbox site.
# (See https://data-sandbox.ess-dive.lbl.gov/#view/doi:10.3334/CDIAC/spruce.001).


# Update the JSON-LD object to a package service

files_tuples_array = []
files_directory = "../../data/files/"
file_name = "text_file2.txt" # TODO: Add your file name here
file_directory = "{}{}".format(files_directory, file_name)

files_tuples_array.append((("json-ld", json.dumps(json_ld))))
files_tuples_array.append(("data", open(file_directory ,'rb')))

id = "<Enter an ESS-DIVE Identifier here>"

put_package_url = "{}{}/{}".format(base,endpoint,id)

metadata_update_dict = {"datePublished": "2019", "name":"Updated"}

put_package_response = requests.put(put_package_url,
                                    headers={"Authorization":header_authorization},
                                    files= files_tuples_array)

if put_package_response.status_code == 200:
   # Success
   response=put_package_response.json()
   print(f"View URL:{response['viewUrl']}")
   print(f"Date Published:{response['dataset']['datePublished']}")
   print(f"Files In Dataset:{response['dataset']['distribution']}")
else:
   # There was an error
   print(put_package_response.text)

