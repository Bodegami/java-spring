db.createUser(
        {
            user: "user",
            pwd: "example",
            roles: [
                {
                    role: "readWrite",
                    db: "books"
                }
            ]
        }
);