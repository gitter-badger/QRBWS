# QRBWS  [![Codeship][codeship-badge]][codeship]

## REST EXAMPLES

```BASH
 curl -i -H "Accept: application/json" -X POST -d "name=authorName" qrbws.herokuapp.com/author/save/
 curl -i -H "Accept: application/json" -X GET qrbws.herokuapp.com/author/show/{id}
 curl -i -H "Accept: application/json" -X GET qrbws.herokuapp.com/author/index
 curl -i -H "Accept: application/json" -X PUT -d "name=Ferran" qrbws.herokuapp.com/author/update/{id}
 curl -i -H "Accept: application/json" -X DELETE qrbws.herokuapp.com/author/delete/{id}
```
[codeship-badge]: https://codeship.com/projects/236e3190-14a3-0133-bdae-063b18755257/status?branch=master
[codeship]: https://codeship.com/projects/93118
