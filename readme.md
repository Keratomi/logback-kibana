### Sample project for Logback-Kibana cooperation

#### Prerequisites

* Maven
* Java
* Docker

#### Steps

* clone this repository
* install elasticsearch
  * get image: `docker pull docker.elastic.co/elasticsearch/elasticsearch:7.5.0`
  * start docker container: `docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.5.0`
  * try: `http://localhost:9200/`
* install logstash
  * get image: `docker pull docker.elastic.co/logstash/logstash:7.5.0`
  * start docker container `docker run --net="host" --rm -it -v [YOUR_LOGSTASH_CONFIG_FILE_FULL_PATH]:/usr/share/logstash/pipeline/logstash.conf -v [YOUR_LOGBACK_LOG_FILE_FULL_PATH]:/var/log/logback.log docker.elastic.co/logstash/logstash:7.5.0`
    * [YOUR_LOGSTASH_CONFIG_FILE_FULL_PATH] /link/
    * [YOUR_LOGBACK_LOG_FILE_FULL_PATH] /link/
  * if you get an error messsage like this> 'Unable to retrieve license information from license server', it doesn't matter the service is running
* install kibana
  * get image: `docker pull docker.elastic.co/kibana/kibana:7.5.0`
  * start docker container: `docker run --link [ELASTICSEARCH_CONTAINER_NAME_OR_ID]:elasticsearch -p 5601:5601 docker.elastic.co/kibana/kibana:7.5.0`
    * [ELASTICSEARCH_CONTAINER_NAME_OR_ID]: the name or id of the running docker container which you had started few minutes ago
  * try: `http://localhost:5601/`