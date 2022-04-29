Feature: Compra de articulos

  Como usuario
  Yo quiero una opcion de comprar articulo
  Y verificar que si sea que producto que seleccione

  Scenario: Compra de maleta
    Given que el usuario se encuentra en el catalogo de productos
    When el selecciona el producto Mochila Sauce Labs
    Then el usuraio deberia poder verlo en el carrito de compras


