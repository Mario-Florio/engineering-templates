import deepEqual from '../shared/__utils__/deepEqual.js';

export default class DB {
    #collection;
    constructor() {
        this.#collection = [];
    }
    create(doc) {
        return this.#collection.push(doc);
    }
    read(filter) {
        return this.#collection.filter(doc => applyFilter(doc, filter));
    }
    update(id, updatedDoc) {
        this.#collection = this.#collection
            .map(doc => doc.id === id ? updatedDoc : doc);
        return updatedDoc;
    }
    delete(id) {
        const doc = this.#collection.find(doc => doc.id);
        this.#collection = this.#collection.filter(doc => doc.id !== id);
        return doc;
    }
}

function applyFilter(doc, filter) {
    return Object.entries(filter).every(([key, val]) => deepEqual(doc[key], val));
}
