package strategy;

public abstract class AttackDecorator implements AttackStrategy {
    protected AttackStrategy decorated;
    public AttackDecorator(AttackStrategy decorated) {
        this.decorated = decorated;
    }
}
