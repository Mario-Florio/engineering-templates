# Clean Architecture Rules

* **Dependency Rule**:

  * Source code dependencies always point **inward**, toward higher-level policies.
  * Inner layers know nothing about outer layers.

* **Layer Independence**:

  * **Entities (core business rules)** must not depend on anything external (frameworks, databases, UI).
  * **Use Cases (application rules)** may depend on entities, but not on frameworks, UI, or infrastructure.
  * **Interface Adapters** (controllers, gateways, presenters) depend on use cases and entities, but not vice versa.
  * **Frameworks & Drivers** (UI, DB, web, CLI, etc.) depend on everything else but are never depended on.

* **Isolation from Frameworks**:

  * Frameworks are considered tools, not architectures.
  * Code should not depend directly on them — they should be plugged in at the outermost layer.

* **Database Independence**:

  * The DB is just a detail.
  * Business logic must not know about schemas, queries, or persistence mechanisms.

* **UI Independence**:

  * Business rules are independent of UI.
  * You should be able to swap web/CLI/mobile without touching core logic.

* **Testability**:

  * Business rules can be tested without a UI, DB, or external systems.
  * Mocks/interfaces handle boundary concerns.

* **Boundaries Defined by Interfaces**:

  * Inner layers define interfaces.
  * Outer layers implement them.
  * This prevents leaking details inward.

* **High-level Policy, Low-level Detail**:

  * Inner circle = high-level policy (what the system does).
  * Outer circle = low-level detail (how it does it).

* **Stable Abstractions Rule** (from SOLID):

  * Stable layers (entities, use cases) are abstract.
  * Volatile layers (frameworks, DBs) are concrete.
