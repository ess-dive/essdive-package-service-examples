import java.io.File;
import java.io.IOException;

//JSON imports
import org.apache.http.HttpEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//Apache http imports

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.client.methods.HttpGet;

// NOTE: You will have to close the class and main blocks by adding two closing curly braces at the end of the document. 
 
public class essdive {

public static void main(String[] args) {
  //Configuration variables
  String token = "<Enter your authorization token here>"; // TODO: Add your token here
  String base = "https://api-sandbox.ess-dive.lbl.gov/";
  String header_authorization = "bearer " + token;
  String endpoint = "packages";
  
  
    //JSON objects variables
  JSONObject provider_spruce_json = new JSONObject();
  JSONObject member = new JSONObject();
  JSONObject funder = new JSONObject();
  JSONObject temporalCoverage = new JSONObject();
  JSONObject editor = new JSONObject();
  JSONObject spatial_coverage_json = new JSONObject();
  JSONObject primary_Creator = new JSONObject();
  JSONObject secondary_Creator = new JSONObject();
  JSONObject geo_northwest = new JSONObject();
  JSONObject geo_southeast = new JSONObject();
  JSONObject JSON_LD = new JSONObject();

  JSONArray creators_json = new JSONArray();
  JSONArray spatial_coverage_array = new JSONArray();
  JSONArray geo = new JSONArray();
  JSONArray measurementTechnique = new JSONArray();
  JSONArray JSON_LD_Description = new JSONArray();
  JSONArray keywords = new JSONArray();
  JSONArray variableMeasured = new JSONArray();
           
  // JSON_LD member assignment  
  member.put("@id","http://orcid.org/0000-0001-7293-3561");
  member.put("givenName","Paul J");
  member.put("familyName","Hanson");
  member.put("email","hansonpj@ornl.gov");
  member.put("jobTitle","Principal Investigator");

  // JSON_LD provider spruce assignment  
  provider_spruce_json.put("name","SPRUCE");
  provider_spruce_json.put("member",member);
  
  // JSON_LD primary creator assignment  
  primary_Creator.put("@id","http://orcid.org/0000-0001-7293-3561");
  primary_Creator.put("givenName","Paul J");
  primary_Creator.put("familyName","Hanson");
  primary_Creator.put("affiliation","Oak Ridge National Laboratory");
  primary_Creator.put("email","hansonpj@ornl.gov");

  // JSON_LD secondary creator assignment  
  secondary_Creator.put("givenName","Jeffrey");
  secondary_Creator.put("familyName","Riggs");
  secondary_Creator.put("affiliation","Oak Ridge National Laboratory");
  
// Define as many creators as you need into newer JSON Objects and add them to the creators_json_array
  creators_json.add(primary_Creator);
  creators_json.add(secondary_Creator);

// JSON_LD Strings arrays 
  variableMeasured.add("EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC TEMPERATURE > SURFACE TEMPERATURE > AIR TEMPERATURE");
  variableMeasured.add("EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC WATER VAPOR > WATER VAPOR INDICATORS > HUMIDITY > RELATIVE HUMIDITY");
  variableMeasured.add("EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC PRESSURE > SEA LEVEL PRESSURE");
  variableMeasured.add("EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC TEMPERATURE > SURFACE TEMPERATURE > DEW POINT TEMPERATURE > DEWPOINT DEPRESSION");
  variableMeasured.add("EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC WINDS > SURFACE WINDS > WIND SPEED");
  variableMeasured.add("EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC WINDS > SURFACE WINDS > WIND DIRECTION");
  variableMeasured.add("EARTH SCIENCE > BIOSPHERE > VEGETATION > PHOTOSYNTHETICALLY ACTIVE RADIATION");
  variableMeasured.add("EARTH SCIENCE > ATMOSPHERE > ATMOSPHERIC RADIATION > NET RADIATION");
  variableMeasured.add("EARTH SCIENCE > LAND SURFACE > SURFACE RADIATIVE PROPERTIES > ALBEDO");
  variableMeasured.add("EARTH SCIENCE > LAND SURFACE > SOILS > SOIL TEMPERATURE");
  variableMeasured.add("Precipitation (Total)");
  variableMeasured.add("Irradiance");
  variableMeasured.add("Groundwater Temperature");
  variableMeasured.add("Groundwater Level");
  variableMeasured.add("Volumetric Water Content");
  variableMeasured.add("surface_albedo");
  
  measurementTechnique.add("The stations are equipped with standard sensors for measuring meteorological parameters, solar radiation, soil temperature and moisture, and groundwater temperature and elevation. Note that some sensor locations are relative to nearby vegetation and bog microtopographic features (i.e., hollows and hummocks). See Table 1 in the attached pdf (SPRUCE_EM_DATA_2010_2016_20170620) for a list of measurements and further details. Sensors and data loggers were initially installed and became operational in June, July, and August of 2010. Additional sensors were added in September 2011. Station 3 was removed from service on May 12, 2014.");
  measurementTechnique.add("These data are considered at Quality Level 1. Level 1 indicates an internally consistent data product that has been subjected to quality checks and data management procedures. Established calibration procedures were followed.");           
  
  JSON_LD_Description.add("This data set reports selected ambient environmental monitoring data from the S1 bog in Minnesota for the period June 2010 through December 2016. Measurements of the environmental conditions at these stations will serve as a pre-treatment baseline for experimental treatments and provide driver data for future modeling activities.");
  JSON_LD_Description.add("The site is the S1 bog, a Picea mariana [black spruce] - Sphagnum spp. bog forest in northern Minnesota, 40 km north of Grand Rapids, in the USDA Forest Service Marcell Experimental Forest (MEF). There are/were three monitoring sites located in the bog: Stations 1 and 2 are co-located at the southern end of the bog and Station 3 is located north central and adjacent to an existing U.S. Forest Service monitoring well.");
  JSON_LD_Description.add("There are eight data files with selected results of ambient environmental monitoring in the S1 bog for the period June 2010 through December 2016. One file has the ");
  JSON_LD_Description.add("other seven have the available data for a given calendar year. Not all measurements started in June 2010 and EM3 measurements ended in May 2014.");
  JSON_LD_Description.add("Further details about the data package are in the attached pdf file (SPRUCE_EM_DATA_2010_2016_20170620).");
  
  keywords.add("EARTH SCIENCE > BIOSPHERE > VEGETATION");
  keywords.add("Climate Change");
  
  // JSON_LD spatial coverage assignment  
  spatial_coverage_json.put("description","Site ID: S1 Bog Site name: S1 Bog, Marcell Experimental Forest Description: The site is the 8.1-ha S1 bog, a Picea mariana [black spruce] - Sphagnum spp. ombrotrophic bog forest in northern Minnesota, 40 km north of Grand Rapids, in the USDA Forest Service Marcell Experimental Forest (MEF). The S1 bog was harvested in successive strip cuts in 1969 and 1974 and the cut areas were allowed to naturally regenerate. Stations 1 and 2 are located in a 1974 strip that is characterized by a medium density of 3-5 meter black spruce and larch trees with an open canopy. The area was suitable for siting a monitoring station for representative meteorological conditions on the S1 bog. Station 3 is located in a 1969 harvest strip that is characterized by a higher density of 3-5 meter black spruce and larch trees with a generally closed canopy. Measurements at this station represent conditions in the surrounding stand. Site Photographs are in the attached document");
  spatial_coverage_json.put("geo", geo);
  
  spatial_coverage_array.add(spatial_coverage_json);

   // JSON_LD funder assignment  
  funder.put("@id", "http://dx.doi.org/10.13039/100006206");
  funder.put("name", "U.S. DOE > Office of Science > Biological and Environmental Research (BER)");
  
  // JSON_LD temporalCoverage assignment  
  temporalCoverage.put("startDate","2010-07-16");
  temporalCoverage.put("endDate","2016-12-31");
  
  
  // JSON_LD editor assignment  
  editor.put("@id", "http://orcid.org/0000-0001-7293-3561");
  editor.put("givenName", "Paul J");
  editor.put("familyName", "Hanson");
  editor.put("email", "hansonpj@ornl.gov");
  
  // JSON_LD geo variables assignments  
  geo_northwest.put("name","Northwest");
  geo_northwest.put("latitude",47.50285);
  geo_northwest.put("longitude",-93.48283);

  geo_southeast.put("name","Southeast");
  geo_southeast.put("latitude",47.50285);
  geo_southeast.put("longitude",-93.48283);
  
  geo.add(geo_northwest);
  geo.add(geo_southeast);
  
  // Main JSON_LD
  JSON_LD.put("@context","http://schema.org/");
  JSON_LD.put("@type","Dataset");
  JSON_LD.put("@id","http://dx.doi.org/10.3334/CDIAC/spruce.001");
  JSON_LD.put("name","SPRUCE S1 Bog Environmental Monitoring Data: 2010-2016");
  JSON_LD.put("description",JSON_LD_Description);
  JSON_LD.put("creator",creators_json);
  JSON_LD.put("datePublished","2015");
  JSON_LD.put("keywords",keywords);
  JSON_LD.put("variableMeasured",variableMeasured);
  JSON_LD.put("license","http://creativecommons.org/licenses/by/4.0/");
  JSON_LD.put("spatialCoverage",spatial_coverage_array);
  JSON_LD.put("funder",funder);
  JSON_LD.put("temporalCoverage",temporalCoverage);
  JSON_LD.put("editor",editor);
  JSON_LD.put("provider", provider_spruce_json);
  JSON_LD.put("measurementTechnique",measurementTechnique);
  
  //Utilities objects 
  CloseableHttpClient httpClient = HttpClientBuilder.create().build();
  
  
  //Submit the JSON-LD object to the package service
  try{
              String url = base + endpoint;
              HttpPost request = new HttpPost(url);
              StringEntity params = new StringEntity(JSON_LD.toString()); //Setting the JSON-LD Object to the request params
              request.addHeader("content-type", "application/json");
              request.addHeader("Authorization", header_authorization);
              request.setEntity(params);
  
              HttpResponse response;
              response = httpClient.execute(request);
              HttpEntity entity = response.getEntity();
              String responseString = EntityUtils.toString(entity, "UTF-8");
  
              if(response.getStatusLine().getStatusCode() == 200){
                   System.out.println(response.toString());
                   System.out.println(responseString);
              } else {
                   System.out.println(response.getStatusLine().getReasonPhrase());
                   System.out.println(responseString);
              }
      } catch (Exception ex) {
           System.out.print(ex.getMessage().toString());
         }
         
   // Submit the JSON-LD object and upload files to the package service:
   try{
            String url = base + endpoint;
            HttpPost uploadFile = new HttpPost(url);
            uploadFile.addHeader("Authorization", header_authorization);
            File file_to_upload = new File("/files/text_file.txt"); // TODO: Add your file directory
      
            String content = FileUtils.readFileToString(file_to_upload);
            
            FormBodyPart bodyPart = FormBodyPartBuilder.create()                    
            .setName("files")
            .addField("Content-Disposition", "form-data; name=\"data\"; filename=\"text_file.txt\"") // TODO: Add your file name
            .setBody(new StringBody(content))
            .build();

            MultipartEntityBuilder builder = MultipartEntityBuilder.create()
            .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
            .setContentType(ContentType.MULTIPART_FORM_DATA);
            
            builder.addPart("json-ld", new StringBody(JSON_LD.toString()));
            builder.addPart(bodyPart);
            
            uploadFile.setEntity(builder.build());
            
            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();

            response = httpClient.execute(uploadFile);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(responseEntity, "UTF-8");
            
            if(response.getStatusLine().getStatusCode() == 200){
                 System.out.println(response.toString());
                 System.out.println(responseString);
            } else {
                 System.out.println(response.getStatusLine().getReasonPhrase());
                 System.out.println(responseString);
            }
      } catch (Exception ex) {
           System.out.print(ex.getMessage().toString());
          }
          
          
          
    // Get a list of data packages
    // The following lines of code will get the list of data package metadata that you have permissions to edit.
    //This will return the most recent 25 records. If you have access to more than 25 packages, use the row_start 
    //and page_size query parameters to page through the results. 
    
    try{
            String url = base + endpoint;
            HttpGet request = new HttpGet(url);
            StringEntity params = new StringEntity(JSON_LD.toString()); //Setting the JSON-LD Object to the request params
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", header_authorization);
    
            HttpResponse response;
            response = httpClient.execute(request);
    
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
    
            if(response.getStatusLine().getStatusCode() == 200){
                 System.out.println(response.toString());
                 System.out.println(responseString);
            } else {
                 System.out.println(response.getStatusLine().getReasonPhrase());
                 System.out.println(response.toString());
                 System.out.println(responseString);
            }
      } catch (Exception ex) {
           System.out.print(ex.getMessage().toString());
          }
          
          
      // Get a Single Data package
      // The following lines of code will get the metadata for a single data package that you have permissions to edit. 
      try{
      
                  String id = "<Enter an ESS-DIVE Identifier here>"; // TODO: Add data package id
                  String url = base + endpoint + File.separator + id;
                  HttpGet request = new HttpGet(url);
                  StringEntity params = new StringEntity(JSON_LD.toString()); //Setting the JSON-LD Object to the request params
                  request.addHeader("content-type", "application/json");
                  request.addHeader("Authorization", header_authorization);
      
                  HttpResponse response;
                  response = httpClient.execute(request);
      
                  HttpEntity entity = response.getEntity();
                  String responseString = EntityUtils.toString(entity, "UTF-8");
      
                  if(response.getStatusLine().getStatusCode() == 200){
                       System.out.println(response.toString());
                       System.out.println(responseString);
                  } else {
                       System.out.println(response.getStatusLine().getReasonPhrase());
                       System.out.println(response.toString());
                       System.out.println(responseString);
                  }
        } catch (Exception ex) {
             System.out.print(ex.getMessage().toString());
            }

      // Update a Data package
      // The following lines of code will update the metadata for a data package that you have permissions to edit.

      try{
            String id = "<Enter an ESS-DIVE Identifier here>"; // TODO: Add data package id
            JSONObject JSON_LD_update = new JSONObject();
            JSON_LD_update.put("name","Updated dataset"); // Your update dictionary
            String url = base + endpoint + "/" + id;
            HttpPut request = new HttpPut(url);
            StringEntity params = new StringEntity(JSON_LD_update.toString()); //Setting the JSON-LD Object to the request params
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", header_authorization);
            request.setEntity(params);

            HttpResponse response;
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");

            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.toString());
            System.out.println(response.getStatusLine());

            if(response.getStatusLine().getStatusCode() == 200){
                 System.out.println(response.toString());
                 System.out.println("Dataset updated");
                 System.out.println(responseString);
            } else {
                 System.out.println(response.getStatusLine().getReasonPhrase());
                 System.out.println(responseString);
            }
            } catch (Exception ex) {
                 System.out.print(ex.getMessage().toString());
            }

      // Update a Data package with a file.
      // The following lines of code will update the metadata for a data package that you have permissions to edit.


       try{
             String id = "<Enter an ESS-DIVE Identifier here>"; // TODO: Add data package id
            JSONObject JSON_LD_update = new JSONObject();
            JSON_LD_update.put("name","Updated dataset"); // Your update dictionary
            String url = base + endpoint + "/" + id;
            HttpPut uploadFile = new HttpPut(url);
            uploadFile.addHeader("Authorization", header_authorization);
            File file_to_upload = new File("/files/text_file.txt"); // TODO: Add your file directory

            String content = FileUtils.readFileToString(file_to_upload);


            FormBodyPart bodyPart = FormBodyPartBuilder.create()
            .setName("files")
            .addField("Content-Disposition", "form-data; name=\"data\"; filename=\"text_file.txt\"") // TODO: Add your file name
            .setBody(new StringBody(content))
            .build();

            MultipartEntityBuilder builder = MultipartEntityBuilder.create()
            .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
            .setContentType(ContentType.MULTIPART_FORM_DATA);

            builder.addPart("json-ld", new StringBody(JSON_LD_update.toString()));
            builder.addPart(bodyPart);


            uploadFile.setEntity(builder.build());

            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();

            String responseString = EntityUtils.toString(responseEntity, "UTF-8");

            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.toString());
            System.out.println(response.getStatusLine());

            System.out.println(responseString);

            } catch (Exception ex) {
                 System.out.print(ex.getMessage().toString());
            }
            
        }


   }

