import UseCase from './UseCase.js';

export default class Read extends UseCase {
    constructor(repo, presenter) {
        super(repo, presenter);
    }
    execute(paramObj) {
        const { filter } = paramObj;
        const documents = this.repo.read(filter)
        return this.presenter.present(documents);
    }
}
