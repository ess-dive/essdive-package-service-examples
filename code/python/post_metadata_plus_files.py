from setup import *

# To submit the JSON-LD object along with data files,
# you need to create a folder named files and add your desired file to upload inside it.

files_tuples_array = []
upload_file = "path/to/your_file" # TODO: Add your file directory here

files_tuples_array.append((("json-ld", json.dumps(json_ld))))
files_tuples_array.append(("data", open(upload_file ,'rb')))

post_packages_url = "{}{}".format(base,endpoint)
post_package_response = requests.post(post_packages_url,
                                    headers={"Authorization":header_authorization},
                                    files= files_tuples_array)

if post_package_response.status_code == 201:
   # Success
   response = post_package_response.json()
   print(f"View URL:{response['viewUrl']}")
   print(f"Name:{response['dataset']['name']}")
else:
   # There was an error
   print(post_package_response.text)

