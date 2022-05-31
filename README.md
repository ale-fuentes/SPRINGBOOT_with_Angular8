# Spring Boot and Angular
![](https://img.shields.io/badge/Author-Alejandro_Fuentes_|_fuentesra@hotmail.com-informational?style=flat&logoColor=white&color=4a4c4d)

## Introduction


## How to usse this project


## Backend

> <sub>**About project**</sub><br/>
> <sub>**Type** Maven Project</sub><br/>
> <sub>**Language** Java</sub> <sub>**version** 11</sub><br/>
> <sub>**Spring Boot** v. 2.7.0</sub><br/>
> <sub>**Packagin** Jar</sub><br/>
>_

Create project spring, we can use site [initialzr of spring][link-initializr]

We use next dependencies:
* Spring Web <span style="background-color:#6db33f">**Web**</span>
* MySQL Driver <span style="background-color:#6db33f">**SQL**</span>
* Spring Data JPA <span style="background-color:#6db33f">**SQL**</span>
* Validation <span style="background-color:#6db33f">**I/O**</span>
* Lombok <span style="background-color:#6db33f">**DEVELOPER TOOLS**</span>

Some Markdown text with 

## Frontend

> <sub>**About project**</sub><br/>
> <sub>**Node** v. 16.14.2</sub><br/>
> <sub>**NPM** v. 8.5.5</sub><br/>
> <sub>**Angular CLI** v. 8.3.29</sub><br/>
>_

**some tools**


* I use [`angula CLI`][link-angular-cli], for it need install it.
    ```shell
    # install last version
    npm i @angular/cli

    # install specify version, example angular 8:
    npm i @angular/cli@8

    ```
* Do create one project:
    ```shell
    ng new sitesapp
    ```
* for notifier actions, I use [angular-notifier][link-angular-notifier].
    ```bash
    $ npm i angular-notifier && ng serve
    ```
* I need create a service, use `ng CLI` command:
    ```shell
    # parameter 'g' or 'generate' is same.
    # parameter 's' or 'service is same.
    # indicate 'path/name'
    ng g service service/site.
    ```



> **CURIOSITIES**
>
>You can also add the following modifiers to the version number to vary how >specific you need the version to be:
>
>**caret ^**
>
>Updates you to the most recent major version, as specified by the first number:
>
>```shell
>^4.3.0
># will load the latest 4.x.x release, but will not load 5.x.x
>```
>
>**tilde ~**
>
>Update you to the most recent minor version, as specified by the second number:
>```shell
>~4.3.0
># will load the latest 4.3.x release, but will not load 4.4.x
>```

[link-initializr]: https://start.spring.io/
[link-angular-notifier]: https://www.npmjs.com/package/angular-notifier
[link-angular-cli]: https://www.npmjs.com/package/@angular/cli