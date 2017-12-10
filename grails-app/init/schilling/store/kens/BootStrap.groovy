package schilling.store.kens

class BootStrap {

    def init = { servletContext ->

        Category catOne = new Category(name:"One").save(failOnError:true)
        Category catTwo = new Category(name:"Two").save(failOnError:true)
        Category catNuts = new Category(name:"Nuts").save(failOnError:true)

        Manufacturer manOne = new Manufacturer(name:"Manuone").save(failOnError:true)
        Manufacturer manTwo = new Manufacturer(name:"Manutwo").save(faileOnError:true)
        Manufacturer man03 = new Manufacturer(name:"Manu03").save(faileOnError:true)
        Manufacturer man04 = new Manufacturer(name:"Manu04").save(faileOnError:true)
        Manufacturer man05 = new Manufacturer(name:"Manu05").save(faileOnError:true)
        Manufacturer man06 = new Manufacturer(name:"Manu06").save(faileOnError:true)
        Manufacturer man07 = new Manufacturer(name:"Manu07").save(faileOnError:true)
        Manufacturer man08 = new Manufacturer(name:"Manu08").save(faileOnError:true)
        Manufacturer man09 = new Manufacturer(name:"Manu09").save(faileOnError:true)
        Manufacturer man10 = new Manufacturer(name:"Manu10").save(faileOnError:true)
        Manufacturer man11 = new Manufacturer(name:"Manu11").save(faileOnError:true)
        Manufacturer man12 = new Manufacturer(name:"Manu12").save(faileOnError:true)
        Manufacturer man13 = new Manufacturer(name:"Manu13").save(faileOnError:true)
        Manufacturer man14 = new Manufacturer(name:"Manu14").save(faileOnError:true)
        Manufacturer man15 = new Manufacturer(name:"Manu15").save(faileOnError:true)
        Manufacturer man16 = new Manufacturer(name:"Manu16").save(faileOnError:true)
        Manufacturer man17 = new Manufacturer(name:"Manu17").save(faileOnError:true)
        Manufacturer manNutty = new Manufacturer(name:"Nutty").save(faileOnError:true)

        new Product(name: "POne",description: "Described",category: catOne, manufacturer: manOne, price: 10.10).save(failOneError:true)
        new Product(name: "PTwo",description: "Described",category: catTwo, manufacturer: manTwo, price: 20.20).save(failOneError:true)

        byte[] macadamiaNutsImageBytes = this.class.getClassLoader().getResourceAsStream("macadamia_nuts.jpeg").bytes
        byte[] brazilNutsImageBytes = this.class.getClassLoader().getResourceAsStream("brazil_nuts.jpeg").bytes
        def prod1 = new Product(name: "Macadamia Nuts",description: "Macadamias 1lb",category: catNuts, manufacturer: manNutty, price: 10.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        def prod2 = new Product(name: "Macadamia Nuts",description: "Macadamias 2lb",category: catNuts, manufacturer: manNutty, price: 20.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 3lb",category: catNuts, manufacturer: manNutty, price: 30.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 4lb",category: catNuts, manufacturer: manNutty, price: 40.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 5lb",category: catNuts, manufacturer: manNutty, price: 50.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 6lb",category: catNuts, manufacturer: manNutty, price: 60.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 7lb",category: catNuts, manufacturer: manNutty, price: 70.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 8lb",category: catNuts, manufacturer: manNutty, price: 80.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 9lb",category: catNuts, manufacturer: manNutty, price: 90.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 10lb",category: catNuts, manufacturer: manNutty, price: 100.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Macadamia Nuts",description: "Macadamias 11lb",category: catNuts, manufacturer: manNutty, price: 110.10, imageBytes: macadamiaNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        def prod3 = new Product(name: "Brazil Nuts",description: "Brazils 1lb",category: catNuts, manufacturer: manNutty, price: 10.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 2lb",category: catNuts, manufacturer: manNutty, price: 20.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 3lb",category: catNuts, manufacturer: manNutty, price: 30.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 4lb",category: catNuts, manufacturer: manNutty, price: 40.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 5lb",category: catNuts, manufacturer: manNutty, price: 50.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 6lb",category: catNuts, manufacturer: manNutty, price: 60.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 7lb",category: catNuts, manufacturer: manNutty, price: 70.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 8lb",category: catNuts, manufacturer: manNutty, price: 80.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 9lb",category: catNuts, manufacturer: manNutty, price: 90.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 10lb",category: catNuts, manufacturer: manNutty, price: 100.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)
        new Product(name: "Brazil Nuts",description: "Brazils 11lb",category: catNuts, manufacturer: manNutty, price: 110.10, imageBytes: brazilNutsImageBytes, imageContentType: 'image/jpeg').save(failOneError:true)

        new ProductOrder(number:'1234',product:prod1,quantity:1).save(failOnError:true)
        new ProductOrder(number:'1235',product:prod2,quantity:2).save(failOnError:true)
        new ProductOrder(number:'1236',product:prod2,quantity:3).save(failOnError:true)
        new ProductOrder(number:'1237',product:prod3,quantity:4).save(failOnError:true)
        new ProductOrder(number:'1238',product:prod3,quantity:5).save(failOnError:true)
    }
    def destroy = {
    }
}
