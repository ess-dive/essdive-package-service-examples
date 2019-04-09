from setup import *

# The following lines of code will get the list of data package metadata
# that you have permissions to edit.  This will return the most recent 25 records.
# If you have access to more than 25 packages, use the row_start and page_size query
# parameters to page through the results.


get_packages_url = "{}{}".format(base,endpoint)
get_packages_response = requests.get(get_packages_url,
    headers={"Authorization":header_authorization})

if get_packages_response.status_code == 200:
   #Success
   print(get_packages_response.json())
else:
   # There was an error
   print(get_packages_response.text)


