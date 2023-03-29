Feature: BookResource

  @post
  Scenario: Create new book with new author and get it and then delete (included author) it
    Given url "http://localhost:8080/books/create"
    And request {"author": {"firstName": "Patrick Radden", "lastName": "Keefe"},"title": "Empire of Pain","imageUrl": "https://api.time.com/wp-content/uploads/2021/11/100-best-books-empire-of-pain.jpg?quality=85&w=1600"}
    When method post
    Then status 201
    Given url "http://localhost:8080/books/"
    And path "Empire of Pain"
    When method get
    Then status 200
    And match $ == {"id": "#number", "title": "Empire of Pain", "imageUrl": "https://api.time.com/wp-content/uploads/2021/11/100-best-books-empire-of-pain.jpg?quality=85&w=1600", "author": {"id": "#number", "firstName": "Patrick Radden", "lastName": "Keefe"}}
    Given url "http://localhost:8080/books/delete"
    And request "Empire of Pain"
    When method delete
    Then status 200
    And match $ == true

  @post
  Scenario: Create new book with new author and get it and then delete (included author) it
    Given url "http://localhost:8080/books/create"
    And request {"author": {"firstName": "Patrick Radden", "lastName": "Keefe"},"title": "Empire of Pain","imageUrl": "https://api.time.com/wp-content/uploads/2021/11/100-best-books-empire-of-pain.jpg?quality=85&w=1600"}
    When method post
    Then status 201

  @get
  Scenario: Get book by id
    Given url "http://localhost:8080/books/book/2"
    When method get
    Then status 200
    And match $ == {"id": 3, "title": "Tribute von Panem Tödliche Spiele", "imageUrl": "https://m.media-amazon.com/images/I/51Vn6qGi6bL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg", "author": {"id": 2, "firstName": "Suzanne", "lastName": "Collins"}}

  @get
  Scenario: Get book by id
    Given url "http://localhost:8080/books/book/3"
    When method get
    Then status 200
    And match $ == {"id": 3, "title": "Tribute von Panem Tödliche Spiele", "imageUrl": "https://m.media-amazon.com/images/I/51Vn6qGi6bL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg", "author": {"id": 2, "firstName": "Suzanne", "lastName": "Collins"}}

  @delete
  Scenario: Delete book by name
    Given url "http://localhost:8080/books/delete"
    And request "Empire of Pain"
    When method delete
    Then status 200
    And match $ == true

    @get
    Scenario: Get book by author
      Given url "http://localhost:8080/books/author?firstName=Suzanne&lastName=Collins"
      When method get
      Then status 200
      And match $ == [{"id":3,"author":{"id":2,"firstName":"Suzanne","lastName":"Collins"},"title":"Tribute von Panem Tödliche Spiele","imageUrl":"https://m.media-amazon.com/images/I/51Vn6qGi6bL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg"},{"id":4,"author":{"id":2,"firstName":"Suzanne","lastName":"Collins"},"title":"Tribute von Panem Flammender Zorn","imageUrl":"https://m.media-amazon.com/images/I/51Cy1AnhfOL._SX218_BO1,204,203,200_QL40_FMwebp_.jpg"}]