import UseCase from './UseCase.js';

export default class ReadOne extends UseCase {
    constructor(repo, presenter) {
        super(repo, presenter);
    }
    execute(paramObj) {
        const { filter } = paramObj;
        const document = this.repo.read(filter)[0] ?? null
        return this.presenter.present(document);
    }
}
