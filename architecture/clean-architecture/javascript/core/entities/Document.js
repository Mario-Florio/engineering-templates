import uid from '../../shared/__utils__/uid.js';

export default class Document {
    constructor(content) {
        this.id = uid();
        for (const key in content) {
            this[key] = content[key];
        }
    }
}
