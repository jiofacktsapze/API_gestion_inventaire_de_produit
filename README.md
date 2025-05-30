# API_gestion_inventaire_de_produit
🛠️ Product API – Spring Boot 3.2.6
Cette API permet de gérer un stock de produits : création, lecture, mise à jour, suppression et affichage des produits en faible stock. Elle est développée avec Spring Boot 3.2.6 et documentée grâce à Swagger/OpenAPI.


✅ Prérequis
    • IDE recommandé : IntelliJ IDEA
    • Outils de test : Swagger UI ou Postman (optionnel)
    • Environnement : JDK 21 et Maven
    • PostgreSQL
    • Docker (pour tester avec une BDD Dockerisée)
      

🚀 Lancement du projet
    1. Cloner le dépôt :
       git clone https://github.com/jiofacktsapze/API_gestion_inventaire_de_produit
    2. Configurer la base de données dans application.properties :
       Exemple :
       spring.datasource.url=jdbc:postgresql://localhost:5442/product-app
       spring.datasource.username=postgres
       spring.datasource.password=motdepasse
       spring.jpa.hibernate.ddl-auto=update
    3. Lancer l’application :
       ./mvnw spring-boot:run
       L’application sera disponible à l’adresse :
➤ http://localhost:8080

📚 Documentation Swagger
Une fois l’application démarrée, la documentation Swagger est disponible à :
👉 http://localhost:8080/swagger-ui.html
Ou (si redirigé automatiquement) :
👉 http://localhost:8080/swagger-ui/index.html
📦 Points de terminaison disponibles
✅ Créer un produit

POST /api/products
Exemple de corps JSON :
{
  "name": "Savon liquide",
  "price": 1500,
  "quantity": 10
}

📋 Récupérer tous les produits

GET /api/products

🔄 Mettre à jour un produit

PUT /api/products/{id}
Exemple de corps JSON :

{
  "name": "Savon antibactérien",
  "price": 2000,
  "quantity": 15
}

🗑️ Supprimer un produit
DELETE /api/products/{id}

⚠️ Produits en stock faible

GET /api/products/Low-stock

⚠️ Validation
    • Le prix et la quantité doivent être strictement supérieurs à 0, sinon une erreur 400 sera renvoyée.
    • Le nom du produit est requis.

💡 Conseils de test

- Utilise Swagger UI pour tester facilement toutes les routes.
- Utilise Postman ou Curl pour tests avancés.
- Vérifie les logs en cas d’erreur (`target/classes/logs` ou console).

 📂 Structure du projet

com.jiofack.products
├── config   	        # Swagger
├── controller      # Contrôleurs REST
├── dto                # Objets de transfert de données
├── exceptions    # Gestion des exceptions
├── models          # Entités JPA
├── repository     # Interfaces d'accès à la BD
└── services        # Logique métier
