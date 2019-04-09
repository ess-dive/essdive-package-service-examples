from setup import *

# The following lines of code will get the metadata
# for a single data package that you have permissions to edit.

id = "<Enter an ESS-DIVE Identifier here>"

get_package_url = "{}{}/{}".format(base,endpoint,id)
get_package_response = requests.get(get_package_url,
    headers={"Authorization":header_authorization})

if get_package_response.status_code == 200:
   #Success
   print(get_package_response.json())
else:
   # There was an error
   print(get_package_response.text)