import UseCase from './UseCase.js';
import Document from '../entities/Document.js';

export default class Update extends UseCase {
    constructor(repo, presenter) {
        super(repo, presenter);
    }
    execute(paramObj) {
        const { id, updatedData } = paramObj;
        const document = this.repo.update(id, new Document(updatedData));
        return this.presenter.present(document);
    }
}
