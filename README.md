This is an easy console-based Java game where two heroes fight each other.
The player controls the warrior Arthur by choosing different types of attacks from the console, while the mage Merlin responds automatically.
The fight continues until one of the heroes is defeated.

The project demonstrates the use of object-oriented design and four design patterns:
Strategy - used for changing attack behavior. The hero can switch between melee, ranged, and magic attacks during the battle.
Observer - used to notify other parts of the system about events. Each attack, health update, or death is automatically reported to the logger and announcer.
Factory - used to create heroes of different types (warrior, mage, archer) in a clean and centralized way.
Decorator - used to add extra effects to attacks, such as critical hits, without changing the base attack logic.

This project shows how design patterns make code more flexible, organized, and easy to extend. New attack types, heroes, or effects can be added without rewriting existing code!!
