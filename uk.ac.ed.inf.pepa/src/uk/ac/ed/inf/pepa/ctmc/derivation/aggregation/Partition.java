package uk.ac.ed.inf.pepa.ctmc.derivation.aggregation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Giacomo Alzetta
 *
 */
public class Partition<S extends Comparable<S>, P extends PartitionBlock<S>> {

	HashSet<P> blocks;
	HashMap<S, P> stateToBlock;
	HashMap<S, String> state_labels;

	public Partition() {
		blocks = new HashSet<>();
		stateToBlock = new HashMap<>();
		state_labels = new HashMap<S, String>();
	}

	public void setStateLabels(HashMap<S, String> state_labels) {
		for (S state : state_labels.keySet()) {
			if (!stateToBlock.containsKey(state)) {
				throw new IllegalArgumentException(state_labels.get(state)
												   + " does not correspond to any state"
												   + " in the partition.");
			}
		}

		for (S state : stateToBlock.keySet()) {
			if (!state_labels.containsKey(state)) {
				throw new IllegalArgumentException(state + " has no label.");
			}
		}

		this.state_labels = new HashMap<S, String>(state_labels);
	}

	public void addBlock(P block) {
		// this should never be called with a block already in the partition.
		assert !blocks.contains(block);
		if (blocks.add(block)) {
			for (S state: block) {
				stateToBlock.put(state, block);
			}
		}
	}

	public void addBlocks(Iterable<P> blocks) {
		for (P block : blocks) {
			addBlock(block);
		}
	}

	public Collection<P> getBlocks() {
		return blocks;
	}

	public P getBlockOf(S state) {
		return stateToBlock.get(state);
	}

	public void updateWithSplit(Iterable<P> subBlocks) {
		addBlocks(subBlocks);
		ArrayList<P> emptyBlocks = new ArrayList<>();
		for (P block: subBlocks) {
			if (block.isEmpty()) {
				emptyBlocks.add(block);
			}
		}

		blocks.removeAll(emptyBlocks);
	}

	public int size() {
		return blocks.size();
	}

	@Override
	public String toString() {
		if (state_labels.size()==0) {
			return "Partition(" + blocks.toString() + ")";
		}

		StringBuilder builder = new StringBuilder();

		builder.append("Partition(");
		String part_sep="";
		for (P block : blocks) {
			builder.append(part_sep);
			builder.append("Class(");
			String block_sep="";
			for (S state : block) {
				builder.append(block_sep);
				builder.append(state_labels.get(state));
				block_sep=",";
			}
			builder.append(")");
			part_sep=", ";
		}
		builder.append(")");

		return builder.toString();
	}
}
