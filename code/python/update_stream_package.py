from setup import *
from requests_toolbelt.multipart.encoder import MultipartEncoder


id = ""  # TODO: Add your package identifier here.
files_upload_directory = "" # TODO: Add your file directory here

files_tuples_array = []
files = os.listdir(files_upload_directory)

files_tuples_array.append(("json-ld", json.dumps({"datePublished": "2019", "name":"Updated title"})
                           ))

for filename in files:
    file_directory = files_upload_directory + filename
    files_tuples_array.append(('data', (filename, open(file_directory, 'rb'))))
m = MultipartEncoder(fields=files_tuples_array)


put_package_url = "{}{}/{}".format(base,endpoint,id)


put_package_response = requests.put(put_package_url,
                                    headers={"Authorization":header_authorization,
                                             'Content-Type': m.content_type},
                                    data=m)

if put_package_response.status_code == 200:
    # Success
    response=put_package_response.json()
    print(f"View URL:{response['viewUrl']}")
    print(f"Date Published:{response['dataset']['datePublished']}")
    print(f"Files In Dataset:{response['dataset']['distribution']}")
else:
    # There was an error
    print(put_package_response.text)

