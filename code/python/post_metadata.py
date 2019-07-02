from setup import *

# The following lines of code validate JSON-LD metadata for a single data package.
# The example provided is from the ESS-DIVE sandbox site.
# (See https://data-sandbox.ess-dive.lbl.gov/#view/doi:10.3334/CDIAC/spruce.001).


# Submit the JSON-LD object to the package service

post_packages_url = "{}{}".format(base,endpoint)
post_package_response = requests.post(post_packages_url,
                                    headers={"Authorization":header_authorization},
                                    json=json_ld)

if post_package_response.status_code == 201:
   # Success
   response = post_package_response.json()
   print(f"View URL:{response['viewUrl']}")
   print(f"Name:{response['dataset']['name']}")
else:
   # There was an error
   print(post_package_response.text)

