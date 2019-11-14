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


___

## Methods

### Actors

#### Fetching all actor:

    GET /actors?page=0&size=10&sort=title
    
| Parameter     | Description                               | Optional |
| -----------   | ----------------------------------------- | -------- |
| `page`        | Page offset                               |   Yes    |
| `size`        | Size limit / number of actors to fetch    |   Yes    |
| `sort`        | Column name for sorting                   |   Yes    |

Sort parameter should be a valid column name from [Actor](#actor) Entity. 

Returns a list of [Actor](#actor).

#### Getting an actor by Id :

    GET /actors/:id

| Attribute   | Description         |
| ----------- | ------------------- |
| `id`        | actorid             |

Returns a [Actor](#actor).

#### Getting a movie image by Id :

**🚧 Work in progress : not avalaibale yet**

    GET /actors/image/:id

| Attribute   | Description         |
| ----------- | ------------------- |
| `id`        | actorid             |

#### Getting an actor filmography by Id :

    GET /actors/filmography/:id

| Attribute   | Description         |
| ----------- | ------------------- |
| `id`        | actorid             |

Return a list of [Movie](#movie)

## Entities

#### Actor

| Attribute              | Description                                              | Nullable |
|------------------------|----------------------------------------------------------|----------|
| `actorid` 🔑           | Actor id and primary Key                                 | no       |
| `name`                 | Name of the actor                                        | no       |
| `moviecount`           | Number of movies done by Actor                           | no       |
| `ratingsum`            | Number of rating given by users                          | no       |
| `normalizedmovierank`  | Actor rank over others                                   | no       |
| `googlehits`           | Actor number of hits on google search                    | no       |
| `normalizedgooglerank` | Actor rank on google                                     | yes       |
| `normalizedrating`     | Actor global rating by users                             | no       |

#### Movie

| Attribute                | Description                                              | Nullable |
|--------------------------|----------------------------------------------------------|----------|
| `imdbid`                 | IMDB Movie ID and primary Key                            | no       |
| `title`                  | Title of the movie                                       | no       |
| `releaseyear`            | Release Year                                             | no       |
| `releasedate`            | Release Date                                             | no       |
| `genre`                  | Movie genre                                              | no       |
| `writers`                | List of writers                                          | no       |
| `actors`                 | List of actors                                           | no       |
