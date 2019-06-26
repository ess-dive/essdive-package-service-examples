
# Setup the JSON for the “provider”. This is the details about the project.
# The project will be listed as the publisher in the citation.


provider_spruce = {
   "name": "SPRUCE",
   "member": {
     "@id": "http://orcid.org/0000-0001-7293-3561",
     "givenName": "Paul J",
     "familyName": "Hanson",
     "email": "hansonpj@ornl.gov",
     "jobTitle": "Principal Investigator"
   }
 }

#Prepare the data package authors in the order that you would like them to appear in the citation.


creators =  [
   {
     "@id": "http://orcid.org/0000-0001-7293-3561",
     "givenName": "Paul J",
     "familyName": "Hanson",
     "affiliation": "Oak Ridge National Laboratory",
     "email": "hansonpj@ornl.gov"
   },
   {
     "givenName": "Jeffrey",
     "familyName": "Riggs",
     "affiliation": "Oak Ridge National Laboratory"
   },
   {
     "givenName": "C",
     "familyName": "Nettles",
     "affiliation": "Oak Ridge National Laboratory"
   },
   {
     "givenName": "William",
     "familyName": "Dorrance",
     "affiliation": "Oak Ridge National Laboratory"
   },
   {
     "givenName": "Les",
     "familyName": "Hook",
     "affiliation": "Oak Ridge National Laboratory"
   }
 ]

# Create the rest of the JSON-LD object

json_ld = {
 "@context": "http://schema.org/",
 "@type": "Dataset",
 "@id": "http://dx.doi.org/10.3334/CDIAC/spruce.001",
 "name": "SPRUCE S1 Bog Environmental Monitoring Data: 2010-2016",
 "description": [
   "This data set reports selected ambient environmental monitoring data from the S1 bog in Minnesota for the period June 2010 through December 2016. Measurements of the environmental conditions at these stations will serve as a pre-treatment baseline for experimental treatments and provide driver data for future modeling activities.",
   "The site is the S1 bog, a Picea mariana [black spruce] - Sphagnum spp. bog forest in northern Minnesota, 40 km north of Grand Rapids, in the USDA Forest Service Marcell Experimental Forest (MEF). There are/were three monitoring sites located in the bog: Stations 1 and 2 are co-located at the southern end of the bog and Station 3 is located north central and adjacent to an existing U.S. Forest Service monitoring well.",
   "There are eight data files with selected results of ambient environmental monitoring in the S1 bog for the period June 2010 through December 2016. One file has the ",
   "other seven have the available data for a given calendar year. Not all measurements started in June 2010 and EM3 measurements ended in May 2014.",
   "Further details about the data package are in the attached pdf file (SPRUCE_EM_DATA_2010_2016_20170620)."
 ],
 "creator": creators,
 "datePublished": "2015",
 "keywords": [
   "EARTH SCIENCE > BIOSPHERE > VEGETATION",
   "Climate Change"
 ],
 "variableMeasured": [
   "EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC TEMPERATURE > SURFACE TEMPERATURE > AIR TEMPERATURE",
   "EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC WATER VAPOR > WATER VAPOR INDICATORS > HUMIDITY > RELATIVE HUMIDITY",
   "EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC PRESSURE > SEA LEVEL PRESSURE",
   "EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC TEMPERATURE > SURFACE TEMPERATURE > DEW POINT TEMPERATURE > DEWPOINT DEPRESSION",
   "EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC WINDS > SURFACE WINDS > WIND SPEED",
   "EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC WINDS > SURFACE WINDS > WIND DIRECTION",
   "EARTH SCIENCE > BIOSPHERE > VEGETATION > PHOTOSYNTHETICALLY ACTIVE RADIATION",
   "EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC RADIATION > NET RADIATION",
   "EARTH SCIENCE > LAND SURFACE > SURFACE RADIATIVE PROPERTIES > ALBEDO",
   "EARTH SCIENCE > LAND SURFACE > SOILS > SOIL TEMPERATURE",
   "Precipitation (Total)",
   "Irradiance",
   "Groundwater Temperature",
   "Groundwater Level",
   "Volumetric Water Content",
   "surface_albedo"
 ],
 "license": "http://creativecommons.org/licenses/by/4.0/",
 "spatialCoverage": [
   {
     "description": "Site ID: S1 Bog Site name: S1 Bog, Marcell Experimental Forest Description: The site is the 8.1-ha S1 bog, a Picea mariana [black spruce] - Sphagnum spp. ombrotrophic bog forest in northern Minnesota, 40 km north of Grand Rapids, in the USDA Forest Service Marcell Experimental Forest (MEF). The S1 bog was harvested in successive strip cuts in 1969 and 1974 and the cut areas were allowed to naturally regenerate. Stations 1 and 2 are located in a 1974 strip that is characterized by a medium density of 3-5 meter black spruce and larch trees with an open canopy. The area was suitable for siting a monitoring station for representative meteorological conditions on the S1 bog. Station 3 is located in a 1969 harvest strip that is characterized by a higher density of 3-5 meter black spruce and larch trees with a generally closed canopy. Measurements at this station represent conditions in the surrounding stand. Site Photographs are in the attached document",
     "geo": [
       {
         "name": "Northwest",
         "latitude": 47.50285,
         "longitude": -93.48283
       },
       {
         "name": "Southeast",
         "latitude": 47.50285,
         "longitude": -93.48283
       }
     ]
   }
 ],
 "funder": {
   "@id": "http://dx.doi.org/10.13039/100006206",
   "name": "U.S. DOE > Office of Science > Biological and Environmental Research (BER)"
 },
 "temporalCoverage": {
   "startDate": "2010-07-16",
   "endDate": "2016-12-31"
 },
 "editor": {
   "@id": "http://orcid.org/0000-0001-7293-3561",
   "givenName": "Paul J",
   "familyName": "Hanson",
   "email": "hansonpj@ornl.gov"
 },
 "provider": provider_spruce,
 "measurementTechnique": [
   "The stations are equipped with standard sensors for measuring meteorological parameters, solar radiation, soil temperature and moisture, and groundwater temperature and elevation. Note that some sensor locations are relative to nearby vegetation and bog microtopographic features (i.e., hollows and hummocks). See Table 1 in the attached pdf (SPRUCE_EM_DATA_2010_2016_20170620) for a list of measurements and further details. Sensors and data loggers were initially installed and became operational in June, July, and August of 2010. Additional sensors were added in September 2011. Station 3 was removed from service on May 12, 2014.",
   "These data are considered at Quality Level 1. Level 1 indicates an internally consistent data product that has been subjected to quality checks and data management procedures. Established calibration procedures were followed."
 ]
}