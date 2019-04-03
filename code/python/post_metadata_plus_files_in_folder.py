from setup import *

# In case you have many files to be uploaded,
# you can place them all inside the files directory and use the following code:

files_tuples_array = []
files_directory = "../../data/files/"
files = os.listdir(files_directory)

files_tuples_array.append((("json-ld", json.dumps(json_ld))))

for filename in files:
    file_directory = files_directory + filename
    files_tuples_array.append((("data", open(file_directory, 'rb'))))

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
