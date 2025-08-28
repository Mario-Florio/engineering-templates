import implementsInterface from '../../shared/__utils__/implementsInterface.js';
import IRepository from '../ports/IRepository.js';

export default class UseCase {
    #repo;
    #presenter;
    constructor(repo, presenter) {
        if (!implementsInterface(repo, IRepository)) throw new Error('Invalid Interface implementation');
        this.#repo = repo;
        this.#presenter = presenter;
    }
    get repo() {
        return this.#repo
    }
    get presenter() {
        return this.#presenter;
    }
}
