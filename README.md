# hololive-clip-api

[![Maven](https://badgen.net/badge/icon/maven?icon=maven&label)](https://https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This Code use Java with HTTP Call from Youtube API to crawl videos, not using third party library

## Getting Started

-----------------------

### Config

Go to `src/main/resources/application.properties` and replace `{YOUR_API_KEY}` with your API Key

  ```
  application.youtube.apiKey={YOUR_API_KEY}
  ```

### Installation

-----------------------

1. Clone the repo
   ```sh
   git clone https://github.com/SeiSilver/hololive-clip-api.git
   ```
2. Build code
   ```sh
   mvn clean install
   ```
3. Run
   ```sh
   java -jar target/hololive-clip-api-0.0.1.jar
   ```

## Usage

-----------------------

Call API: `http://localhost:8080/clips/api/search?query=&size=&pageToken=`

   ```
   query: video title or talent you want to search (required)
   size: number of videos (default value is 50) (optional)
   pageToken: token use to move to next page of the result (optional)
   ```

## Note

- Calling Api from YouTube will consume some of your Quota, daily your quota will refill to 10000
- For search request will consume 100 Quota per request

For more detail: [Quota Cost](https://developers.google.com/youtube/v3/determine_quota_cost)

### Document

-----------------------

[Youtube API Document](https://developers.google.com/youtube/v3/docs/search/list)
