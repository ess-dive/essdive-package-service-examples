import requests
import os
import json
from jsonld_construction import json_ld

env_configs = os.environ.copy()
token = env_configs["ESS_DIVE_AUTH_TOKEN"]
base = "https://api-sandbox.ess-dive.lbl.gov/"
header_authorization =  "bearer {}".format(token)
endpoint = "packages"