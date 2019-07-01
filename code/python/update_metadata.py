from setup import *

# The following lines of code update JSON-LD metadata for a single data package.
# The example provided is from the ESS-DIVE sandbox site.
# (See https://data-sandbox.ess-dive.lbl.gov/#view/doi:10.3334/CDIAC/spruce.001).


# Update the JSON-LD object to a package service

id = "<Enter an ESS-DIVE Identifier here>"
put_package_url = "{}{}/{}".format(base,endpoint,id)

metadata_update_dict = {"name": "Updated Dataset Name"}

put_package_response = requests.put(put_package_url,
                                    headers={"Authorization":header_authorization},
                                    json=metadata_update_dict)

if put_package_response.status_code == 200:
   # Success
   response=put_package_response.json()
   print(f"View URL:{response['viewUrl']}")
   print(f"Name:{response['dataset']['name']}")
else:
   # There was an error
   print(put_package_response.text)

