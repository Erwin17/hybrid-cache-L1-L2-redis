// Script de inicialización

db = db.getSiblingDB("product_catalog_db");

// Elimina la colección si ya existe
db.products.drop();

// Crea nuevamente la colección
db.createCollection("products");

// Genera e inserta 10.000 productos
const products = [];

for (let i = 1; i <= 500000; i++) {
    products.push({
        //_id: UUID().toString(),
        name: `product-${String(i).padStart(5, "0")}`,
        price: i * 2,
        description: `description-${String(i).padStart(5, "0")}`
    });

    // Inserta por lotes de 100000 documentos
    if (products.length === 100000) {
        db.products.insertMany(products);
        products.length = 0;
    }
}

// Inserta los registros restantes
if (products.length > 0) {
    db.products.insertMany(products);
}

print(`Se insertaron ${db.products.countDocuments()} productos.`);