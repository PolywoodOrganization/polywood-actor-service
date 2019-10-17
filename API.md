API overview
============

## Content

- [Notes](#notes)
- [Methods](#methods)
  - [Movies](#movies)
- [Entities](#entities)

___

## Notes

###### Introduction



###### Errors



######

Localhost/8080/ is use there as default API URI. If the API is on a remote host or on a different port don't forget to change it.


___

## Methods

### Movies

#### Fetching all movies:

    GET /localhost/8080/movies/

Returns a [Movie](#movie).

#### Getting a movie by Id :

    GET /localhost/8080/movies/:id

| Attribute   | Description         |
| ----------- | ------------------- |
| `id`        | ImdbId              |

## Entities

#### Movie

| Attribute                | Description                                              | Nullable |
|--------------------------|----------------------------------------------------------|----------|
| `ImdbId`                 | IMDB Movie ID and primary Key                            | no       |
| `title`                  | Title of the movie                                       | no       |
| `releaseYear`            | Release Year                                             | no       |
| `releaseDate`            | Release Date                                             | no       |
| `genre`                  | Movie genre                                              | no       |
| `writers`                | List of writers                                          | no       |
| `actors`                 | List of actors                                           | no       |





> **Note:** Work in progress
