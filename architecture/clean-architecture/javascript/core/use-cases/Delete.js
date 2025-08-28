import UseCase from './UseCase.js';

export default class Delete extends UseCase {
    constructor(repo, presenter) {
        super(repo, presenter);
    }
    execute(paramObj) {
        const { id } = paramObj;
        const document = this.repo.delete(id)
        return this.presenter.present(document);
    }
}
