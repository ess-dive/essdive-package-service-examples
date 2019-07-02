from setup import *

# The following lines of code validate JSON-LD metadata for a single data package.
# The example provided is from the ESS-DIVE sandbox site.
# (See https://data-sandbox.ess-dive.lbl.gov/#view/doi:10.3334/CDIAC/spruce.001).


# Update the JSON-LD object to a package service

files_tuples_array = []
upload_file = "path/to/your_file"  # TODO: Add your file directory here

metadata_update_dict = {"datePublished": "2019", "name":"Updated"}

files_tuples_array.append((("json-ld", json.dumps(metadata_update_dict))))
files_tuples_array.append(("data", open(upload_file ,'rb')))

id = "<Enter an ESS-DIVE Identifier here>"

put_package_url = "{}{}/{}".format(base,endpoint,id)


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

