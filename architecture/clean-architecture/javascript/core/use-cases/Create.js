import UseCase from './UseCase.js';
import Document from '../entities/Document.js';

export default class Create extends UseCase {
    constructor(repo, presenter) {
        super(repo, presenter);
    }
    execute(paramObj) {
        const { data } = paramObj;
        const document = this.repo.create(new Document(data));
        return this.presenter.present(document);
    }
}
