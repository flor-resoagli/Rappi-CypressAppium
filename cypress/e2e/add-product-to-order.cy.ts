describe('add product to order', () => {

  beforeEach(() => {
    cy.visit('https://www.rappi.com.ar/restaurantes/135408-mcdonalds').wait(2000)
  })

  it('add product to order', () => {

    cy.get('button[data-qa="add-product"]').first().click()

    cy.get('input[data-qa="address-input"]').first().click().type("Universidad Austral Campus Pilar")
        .wait(1000).type('{enter}').wait(1000)
    cy.get('button[aria-label="Guardar dirección"]').first().click().wait(2000)
    cy.get('button[data-qa="add-product"]').first().click().wait(1000)
    cy.get('div[aria-label="Coca-cola"]').first().click()
    cy.get('button[data-qa="primary-button"]').first().click()
  })
})