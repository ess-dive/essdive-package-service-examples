touch essdive.java
mkdir lib
cd lib

curl -O https://archive.apache.org/dist/httpcomponents/httpclient/binary/httpcomponents-client-4.5.6-bin.zip

curl -O https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/json-simple/json_simple-1.1.jar

curl -O https://archive.apache.org/dist/commons/io/binaries/commons-io-2.6-bin.tar.gz

tar -xvzf commons-io-2.6-bin.tar.gz
mv commons-io-2.6/commons-io-2.6.jar .


unzip httpcomponents-client-4.5.6-bin.zip 
mv httpcomponents-client-4.5.6/lib/* . 