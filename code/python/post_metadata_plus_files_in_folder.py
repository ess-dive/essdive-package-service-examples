from setup import *

# In case you have many files to be uploaded,
# you can place them all inside the files directory and use the following code:

files_tuples_array = []
files_upload_directory = "Your_upload_directory/" # TODO: Add your file directory here
files = os.listdir(files_upload_directory)

files_tuples_array.append((("json-ld", json.dumps(json_ld))))

for filename in files:
    file_directory = files_upload_directory + filename
    files_tuples_array.append((("data", open(file_directory, 'rb'))))

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
