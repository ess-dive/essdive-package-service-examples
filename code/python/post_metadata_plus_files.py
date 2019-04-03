from setup import *

# To submit the JSON-LD object along with data files,
# you need to create a folder named files and add your desired file to upload inside it.

files_tuples_array = []
files_directory = "../../data/files/"
file_name = "text_file.txt" # TODO: Add your file name here
file_directory = "{}{}".format(files_directory, file_name)

files_tuples_array.append((("json-ld", json.dumps(json_ld))))
files_tuples_array.append(("data", open(file_directory ,'rb')))

post_packages_url = "{}{}".format(base,endpoint)
post_package_response = requests.post(post_packages_url,
                                    headers={"Authorization":header_authorization},
                                    files= files_tuples_array)

if post_package_response.status_code == 200:
   # Success
   print(post_package_response.json())
else:
   # There was an error
   print(post_package_response.text)

