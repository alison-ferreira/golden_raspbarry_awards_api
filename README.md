# Golden Raspberry Awards API

This is an API to read an analysis the Golden Raspberry Awards Nominations and Winners.

## Installation

Use the package manager [Maven](http://maven.apache.org/) to build the API.

```bash
mvn install
```

## Usage

Run the API with the following command:
```bash
java -jar file_name.jar
```

After the project is started, access the follow [URL](http://localhost:8080/worst-movies/min-and-max-awards-intervals) to see the minimum and maximum interval of Awards founded in the file:

```
src/main/resources/movielist.csv
```

## Allowed HTTP Methods and EndPoints

```
GET /worst-movies/min-and-max-awards-intervals/
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
