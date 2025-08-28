
export default class Repository {
    #db;
    constructor(db) {
        this.#db = db;
    }
    create(doc) {
        this.#db.create(doc);
        return doc;
    }
    read(filter) {
        return this.#db.read(filter);
    }
    update(id, updatedDoc) {
        return this.#db.update(id, updatedDoc);
    }
    delete(id) {
        return this.#db.delete(id);
    }
}
